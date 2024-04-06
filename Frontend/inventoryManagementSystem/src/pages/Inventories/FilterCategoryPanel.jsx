/**
 * @file A Panel in the InventoriesPage to filter the inventory table by category
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'

// CSS imports
import "./FilterCategoryPanel.css"

function FilterCategoryPanel() {
  // Stores a list containing all (unique) categories 
  const [categories, setCategories] = useState([])

  /**
   * Fetch unique categories.
   * This could be achieved by calling the API, or this could be achieved by analyzing the existing
   * data on the already fetched inventory table
   */
  const fetchUniqueCategories = () => {
    
  }

  return (
    <div className="filter-panel">
    
      {/* The title of this panel */}
      <p className="panel-title">Filter Category</p>


    </div>
  );
}

export default FilterCategoryPanel
