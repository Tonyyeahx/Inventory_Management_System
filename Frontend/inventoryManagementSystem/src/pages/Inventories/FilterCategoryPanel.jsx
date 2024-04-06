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

  // Stores selected categories
  const [selectedCategories, setSelectedCategories] = useState([])

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

  /**
   * Update the "selectedCategories" array with the state of the currently selected category
   * @param {*} category the category to be updated state with
   */
  const updateSelectedCategories = (category) => {
    setSelectedCategories(prevSelectedCategories => {
      // Check if the category is already in the selectedCategories array
      if (prevSelectedCategories.includes(category)) {
        // If it is, remove it (uncheck the box)
        return prevSelectedCategories.filter(cat => cat !== category);
      } else {
        // If it's not, add it (check the box)
        return [...prevSelectedCategories, category];
      }
    });
  }

  /**
   * Called when selectedCategories changes, to let the inventory table to reflect the selection
   * of the filter panel
   */
  const handleFilter = () => {
    console.log(selectedCategories)

    // Use the selectedCategories to filter the inventories
    const filteredInventories = props.inventories.filter(inventory =>
      selectedCategories.includes(inventory.category)
    );
    
    // Update the inventories that are being displayed through props.setInventories
    props.setInventories(filteredInventories);
  }

  useEffect(() => handleFilter, [selectedCategories])

  return (
    <div className="filter-panel">
    
      {/* The title of this panel */}
      <p className="panel-title">Filter Category</p>

      {/* Display the unique categories in checkboxes */}
      <Form className="form">
        {
          uniqueCategories.map(category => (
            <Form.Check className='checkbox'
              key={category}
              type={"checkbox"}
              label={category}
              checked={selectedCategories.includes(category)}
              onChange={() => updateSelectedCategories(category)}
            />
          ))
        }

      </Form>

    </div>
  );
}

export default FilterCategoryPanel
