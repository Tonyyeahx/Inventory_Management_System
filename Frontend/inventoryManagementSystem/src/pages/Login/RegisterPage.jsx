/**
 * @file A register page that allows user to register
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import Alert from 'react-bootstrap/Alert';
import { useNavigate } from 'react-router-dom';

// Internal imports
import teamLogo from "../../assets/TeamLogo.png"

// CSS imports
import "./RegisterPage.css"

function RegisterPage(props) {
  // The account information inputted by the user
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [confirmPassword, setConfirmPassword] = useState("")
  const [privilegeLevel, setPrivilegeLevel] = useState("")
  const [storeID, setStoreID] = useState("")

  // flags to display respective warning messages
  const [isShowUsernameBlank, setIsShowUsernameBlank] = useState(false) // Username field is blank
  const [isShowPasswordBlank, setIsShowPasswordBlank] = useState(false) // Password field is blank
  const [isShowPasswordNotMatch, setIsShowPasswordNotMatch] = useState(false) // Password not match
  const [isShowPrivilegeBlank, setIsShowPrivilegeBlank] = useState(false) // Privilege field is blank
  const [isShowStoreIDBlank, setIsShowStoreIDBlank] = useState(false) // Store ID field is blank

  // Use to navigate back to the login page when the user clicked the "Cancel" button or "Register"
  // button upon a successful registration
  const navigate = useNavigate();

  /**
   * The function handles the register function. 
   * 
   * First, it check if all the fields are filled (with an exception that store ID should be blank
   * for manager users). Then, it will send the user register information to the server. After the 
   * registration is successful, it will bring the user back to login page
   */
  const handleRegister = () => {
    // Mute all warning message at the beginning
    setIsShowUsernameBlank(false)
    setIsShowPasswordBlank(false)
    setIsShowPasswordNotMatch(false)
    setIsShowPrivilegeBlank(false)
    setIsShowStoreIDBlank(false)

    // Check if the user input fields are valid before the communication
    // to backend
    if (username == "") {
      setIsShowUsernameBlank(true)
      return;
    } else if (password == "") {
      setIsShowPasswordBlank(true)
      return;
    } else if (password != confirmPassword) {
      setIsShowPasswordNotMatch(true)
      return;
    } else if (privilegeLevel == "select" || privilegeLevel == "") {
      setIsShowPrivilegeBlank(true);
      return;
    } else if (storeID == "" && privilegeLevel != "manager") {
      // Store ID can be blank if privilegeLevel is manager
      setIsShowStoreIDBlank(true)
    }

    // TODO: Communication to the backend
    alert("Registration Successful!")
    navigate("/")
  }

  return (
    // Contains everything on this page, used to set the background color
    <div className="register-page">

      {/* The logo of this application */}
      <img src={teamLogo} className="logo" alt="Project logo" />

      {/* Contains elements for user inputs, such as text fields and buttons */}
      <div className="user-input-panel">
        <Form>
          {/* Username field */}
          <Form.Label htmlFor="inputUsername">Username</Form.Label>
          <Form.Control 
            className="register-text-fields"
            type="text" 
            id="inputUsername"
            onChange={e => setUsername(e.target.value)}
          />

          {/* Password field */}
          <Form.Label htmlFor="inputPassword">Password</Form.Label>
          <Form.Control
            className="register-text-fields"
            type="password"
            id="inputPassword"
            onChange={e => setPassword(e.target.value)}
          />

          {/* Confirm password field */}
          <Form.Label htmlFor="confirmPassword">Confirm Password</Form.Label>
          <Form.Control
            className="register-text-fields"
            type="password"
            id="confirmPassword"
            onChange={e => setConfirmPassword(e.target.value)}
          />

          {/* Privilege level field */}
          <Form.Label htmlFor="inputPrivilegeLevel">Privilege Level</Form.Label>
          <Form.Select 
            className="register-text-fields"
            onChange={e => setPrivilegeLevel(e.target.value)}
          >
            <option value="select">Select</option>
            <option value="manager">Manager</option>
            <option value="employee">Employee</option>
          </Form.Select>

          {/* Store ID field, disabled for manager users */}
          <Form.Label htmlFor="inputStoreID">Store ID</Form.Label>
          <Form.Control
            disabled={privilegeLevel == "manager"} 
            type="text" 
            id="inputStoreID"
            onChange={e => setCompany(e.target.value)}
          />

          {
            // Display the following message only for manager user
            privilegeLevel == "manager" 
              && <Form.Text>Store ID will be generated for managers</Form.Text>
          }
        </Form>

        {/* Login and register button */}
        <div className="register-cancel-button">
          <Button
            variant="secondary"
            onClick={() => navigate("/")}
          >
            Cancel
          </Button>

          <Button
            onClick={handleRegister}
          >
            Register
          </Button>
        </div>

        {/* The warning messages */}
        {
          isShowUsernameBlank && (
            <Alert variant="warning" className="warnings">
              Username cannot be blank
            </Alert>
          )
        }

        {
          isShowPasswordBlank && (
            <Alert variant="warning" className="warnings">
              Password cannot be blank
            </Alert>
          )
        }

        {
          isShowPasswordNotMatch && (
            <Alert variant="warning" className="warnings">
              Passwords do not match
            </Alert>
          )
        }

        {
          isShowPrivilegeBlank && (
            <Alert variant="warning" className="warnings">
              Privilege cannot be blank
            </Alert>
          )
        }

        {
          isShowStoreIDBlank && (
            <Alert variant="warning" className="warnings">
              Store ID cannot be blank
            </Alert>
          )
        }

      </div>
    </div>
  );

}
  

export default RegisterPage
