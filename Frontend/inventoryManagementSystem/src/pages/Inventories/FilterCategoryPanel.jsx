/**
 * @file A Panel in the InventoriesPage to filter the inventory table by category
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form';


// CSS imports
import "./FilterCategoryPanel.css"

function FilterCategoryPanel(props) {
  // Stores a list containing all (unique) categories 
  const [uniqueCategories, setUniqueCategories] = useState([])

  /**
   * Fetch unique categories.
   * This could be achieved by calling the API, or this could be achieved by analyzing the existing
   * data on the already fetched inventory table
   */
  const fetchUniqueCategories = () => {
    // Filter all unique categories using a set
    setUniqueCategories([...new Set(props.inventories.map(item => item.category))])
  }

  // Only fetch the unique categories when props arrived
  useEffect(fetchUniqueCategories, [props.inventories])

  return (
    <div className="filter-panel">
    
      {/* The title of this panel */}
      <p className="panel-title">Filter Category</p>

      {/* Display the unique categories in checkboxes */}
      <Form>
        {
          uniqueCategories.map(category => (
            <Form.Check 
              key={category}
              type={"checkbox"}
              label={category}
            />
          ))
        }

      </Form>

    </div>
  );
}

export default FilterCategoryPanel
