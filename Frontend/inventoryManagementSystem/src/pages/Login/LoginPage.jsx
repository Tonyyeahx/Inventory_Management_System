/**
 * @file A login page that allows user to login
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import Alert from 'react-bootstrap/Alert';

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

    if (username == "") {
      setIsShowUsernameBlank(true)
    } else if (password == "") {
      setIsShowPasswordBlank(true)
    } else {
      setIsShowWrongLogin(true)
    }

    console.log("username: " + username)
    console.log("password: " + password)

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
          >
            Register</Button>

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
