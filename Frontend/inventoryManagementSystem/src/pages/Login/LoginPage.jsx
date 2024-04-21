/**
 * @file A login page that allows user to login
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
import "./LoginPage.css"

function LoginPage(props) {
  // The username and password inputted by the user
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

  // flags to display respective warning messages
  const [isShowUsernameBlank, setIsShowUsernameBlank] = useState(false) // Username field is blank
  const [isShowPasswordBlank, setIsShowPasswordBlank] = useState(false) // Password field is blank
  const [isShowWrongLogin, setIsShowWrongLogin] = useState(false)   // If username-password incorrect

  // Use to navigate to the inventories page upon a successful login, or the register page if the 
  // user clicked the register button
  const navigate = useNavigate();
  /**
   * The function handles the login function. 
   * 
   * It sends the user-input username and password to the backend server, waits for validation.
   * If the validation succeed, it will direct the user to the inventory page. Otherwise, it will
   * display a warning saying the username or password is incorrect
   * 
   * Additionally, it checks if the username and password text field both are non-blank. If any of 
   * them are blank, it will also shows a warning message saying the username or password is blank
   */
  const handleLogin = () => {
    // Mute all warning message at the beginning
    setIsShowUsernameBlank(false)
    setIsShowPasswordBlank(false)
    setIsShowWrongLogin(false)

    // Check if the username or password fields are blank before the communication
    // to backend
    if (username == "") {
      setIsShowUsernameBlank(true)
      return;
    } else if (password == "") {
      setIsShowPasswordBlank(true)
      return;
    }

    // TODO: Communication to the backend
    // Format the header into "username:password", then do Base64 encoding
    const basicAuthString = btoa(`${username}:${password}`);

    // Construct the authorization header
    const headers = new Headers();
    headers.append('Authorization', `Basic ${basicAuthString}`);

    // Initate the HTTP request
    let URI = "http://localhost:8080"
    fetch(`${URI}/`, {method: 'GET', headers: headers, })
      .then(response => {
        if (response.ok) {
          navigate('/inventories');
        } else {
          setIsShowWrongLogin(true)
        }
      })
  }

  return (
    // Contains everything on this page, used to set the background color
    <div className="login-page">

      {/* The logo of this application */}
      <img src={teamLogo} className="logo" alt="Project logo" />

      {/* Contains elements for user inputs, such as text fields and buttons */}
      <div className="user-input-panel">
        <Form>
          {/* Username field */}
          <Form.Label htmlFor="inputUsername">Username</Form.Label>
          <Form.Control 
            type="text" 
            id="inputUsername"
            onChange={e => setUsername(e.target.value)}
          />

          {/* Password field */}
          <Form.Label htmlFor="inputPassword" id="password-label">Password</Form.Label>
          <Form.Control
            type="password"
            id="inputPassword"
            onChange={e => setPassword(e.target.value)}
          />
        </Form>

        {/* Login and register button */}
        <div className="login-register-button">
          <Button
            variant="secondary"
            onClick={() => navigate("/register")}
          >
            Register
          </Button>
          
          <Button
            onClick={handleLogin}
          >
            Login
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
          isShowWrongLogin && (
            <Alert variant="danger" className="warnings">
              Invalid username or password
            </Alert>
          )
        }
      </div>

    </div>
  );


}
  

export default LoginPage
