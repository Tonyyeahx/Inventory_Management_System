/**
 * @file A login page that allows user to login
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form'

// CSS imports
import "./LoginPage.css"

function LoginPage(props) {

  return (
    // Contains everything on this page, used to set the background color
    <div className="login-page">

      {/* The logo of this application */}

      {/* Contains elements for user inputs, such as text fields and buttons */}
      <div className="user-input-panel">
        I am a login page
      </div>

    </div>
  );


}
  

export default LoginPage
