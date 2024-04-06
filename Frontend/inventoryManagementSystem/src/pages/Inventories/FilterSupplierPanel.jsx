/**
 * @file A Panel in the InventoriesPage to filter the inventory table by supplier
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Form from 'react-bootstrap/Form'
import Spinner from 'react-bootstrap/Spinner'


// CSS imports
import "./FilterPanels.css"

function FilterSupplierPanel(props) {
  // Stores a list containing all (unique) supplier 
  const [uniqueSupplier, setUniqueSupplier] = useState([])

  // Stores selected supplier
  const [selectedSupplier, setSelectedSupplier] = useState([])

  /**
   * Fetch unique supplier.
   * This could be achieved by calling the API, or this could be achieved by analyzing the existing
   * data on the already fetched inventory table
   */
  const fetchUniqueSuppliers = () => {
    // Filter all unique suppliers using a set
    setUniqueSupplier([...new Set(props.cleanInventories.map(item => item.supplier))])

    // By default, selecting all suppliers
    setSelectedSupplier([...new Set(props.cleanInventories.map(item => item.supplier))])
  }

  // Only fetch the unique suppliers when props arrived
  useEffect(fetchUniqueSuppliers, [props.cleanInventories])

  /**
   * Update the "updateSelectedSuppliers" array with the state of the currently selected supplier
   * @param {*} supplier the supplier to be updated state with
   */
  const updateSelectedSuppliers = (supplier) => {
    setSelectedSupplier(prevSelectedSuppliers => {
      // Check if the supplier is already in the selectedSupplier array
      if (prevSelectedSuppliers.includes(supplier)) {
        // If it is, remove it (uncheck the box)
        return prevSelectedSuppliers.filter(sup => sup !== supplier);
      } else {
        // If it's not, add it (check the box)
        return [...prevSelectedSuppliers, supplier];
      }
    });
  }

  /**
   * Called when selectedSupplier changes, to let the inventory table to reflect the selection
   * of the filter panel
   */
  const handleFilter = () => {
    console.log(selectedSupplier)

    // Use the selectedSupplier to filter the inventories
    const filteredInventories = props.cleanInventories.filter(inventory =>
      selectedSupplier.includes(inventory.supplier)
    );
    
    // Update the inventories that are being displayed through props.setInventories
    props.setInventories(filteredInventories);
  }

  useEffect(handleFilter, [selectedSupplier])

  return (
    <div className="filter-panel">
    
      {/* The title of this panel */}
      <p className="panel-title">Filter Supplier</p>

      {
        // Display a spinner while loading the supplier, or the actual supplier checkboxes
        uniqueSupplier.length == 0 
        ? 
          <Spinner animation="border" role="status" />
        :
          <Form className="form">
          {
            uniqueSupplier.map(supplier => (
              <Form.Check className='checkbox'
                key={supplier}
                type={"checkbox"}
                label={supplier}
                checked={selectedSupplier.includes(supplier)}
                onChange={() => updateSelectedSuppliers(supplier)}
              />
            ))
          }
        </Form>
      }

    </div>
  );
}

export default FilterSupplierPanel
