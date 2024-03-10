/**
 * @file The landing page for merchant users, which shows all the inventories in a given store
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'

// Internal imports
import StoreSwitcher from '../../components/StoreSwitcher';

// CSS imports
import "../../App.css"
import "./InventoriesPage.css"

function InventoriesPage() {
  
  return (
    <div className="inventories-page-pane">
      <StoreSwitcher />
    </div>
  );
}

export default InventoriesPage