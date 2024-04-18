/**
 * @file A login page that allows user to login
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'

// Internal imports
import teamLogo from "../../assets/TeamLogo.png"

// CSS imports
import "./LoginPage.css"

function LoginPage(props) {
  // The username and password inputted by the user
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

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
          >Register</Button>

          <Button>Login</Button>
        </div>
      </div>

    </div>
  );


}
  

export default LoginPage
