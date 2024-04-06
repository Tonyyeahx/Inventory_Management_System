/**
 * @file A radio button used in the Inventory Page to switch between 
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect, useContext } from 'react'
import ButtonGroup from 'react-bootstrap/ButtonGroup'
import ToggleButton from 'react-bootstrap/ToggleButton'

// Internal imports

// Context imports
import ViewModeContext from '../context/ViewModeContext'

// CSS imports
import "../App.css"

function ViewEditModeRadioButton() {
  // Toggles between 'View' and 'Edit'
  const [viewEditMode, setViewEditMode] = useContext(ViewModeContext)

  return (
    // The 'w-100' is a React-Bootstrap utility class making the element to take up the full width 
    // of their parent container
    <ButtonGroup className="w-100" size='sm'>
      <ToggleButton 
        id="view-radio-button"
        type='radio'
        variant='outline-secondary'
        checked={viewEditMode == "View"}
        onClick={() => setViewEditMode("View")}
      >
        View
      </ToggleButton>

      <ToggleButton 
        id="edit-radio-button"
        type='radio'
        variant='outline-danger'
        checked={viewEditMode == "Edit"}
        onClick={() => setViewEditMode("Edit")}
      >
        Edit
      </ToggleButton>

    </ButtonGroup>
  );
}


export default ViewEditModeRadioButton

