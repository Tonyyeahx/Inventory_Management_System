/**
 * @file To show the current store vieving, and allow user to switch to another store
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'

// Icon imports
import SwapHorizontalIcon from 'mdi-react/SwapHorizontalIcon';

// CSS imports
import "../App.css"
import "./StoreSwitcher.css"

function StoreSwitcher() {
  return (
    <div className="store-switcher">
      <h1 className="store-name">My Store</h1>
      <SwapHorizontalIcon color="#808080" className="swap-icon" />
    </div>
  )
}

export default StoreSwitcher