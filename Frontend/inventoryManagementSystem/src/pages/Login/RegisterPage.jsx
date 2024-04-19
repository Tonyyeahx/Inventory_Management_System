/**
 * @file A register page that allows user to register
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
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
  const [company, setCompany] = useState("")
  const [privilegeLevel, setPrivilegeLevel] = useState("")

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

          {/* Company/Branch field */}
          <Form.Label htmlFor="inputCompanyBranch">Company/Branch</Form.Label>
          <Form.Control 
            className="register-text-fields"
            type="text" 
            id="inputCompanyBranch"
            onChange={e => setCompany(e.target.value)}
          />

          {/* Privilege level field */}
          <Form.Label htmlFor="inputPrivilegeLevel">Privilege Level</Form.Label>
          <Form.Control 
            className="register-text-fields"
            type="text" 
            id="inputPrivilegeLevel"
            onChange={e => setPrivilegeLevel(e.target.value)}
          />
        </Form>

        {/* Login and register button */}
        <div className="login-register-button">
          <Button
            variant="secondary"
          >
            Cancel
          </Button>

          <Button>
            Register
          </Button>
        </div>

      </div>


    </div>
  );

}
  

export default RegisterPage
