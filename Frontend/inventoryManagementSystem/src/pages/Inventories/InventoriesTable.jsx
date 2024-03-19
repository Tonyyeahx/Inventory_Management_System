/**
 * @file The inventories table shows all inventories matching filter conditions (store, category, 
 *    supplier)
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useEffect, useState} from 'react'
import Table from 'react-bootstrap/Table';
import { BsPencilSquare, BsTrash } from 'react-icons/bs';

// Internal imports
import InventoriesTableRow from './InventoriesTableRow';

// CSS imports
import "../../App.css"

function InventoriesTable(props) {

    // State to manage the selected mode (Read or Edit)
    const [mode, setMode] = useState('Read');

    // Toggle function to switch between Read and Edit modes
    const toggleMode = () => {
      setMode(mode === 'Read' ? 'Edit' : 'Read');
    };

  return (
    <div>
    {/* Radio buttons for Read and Edit modes */}
    <div>
      <input
        type="radio"
        id="readMode"
        name="mode"
        value="Read"
        checked={mode === 'Read'}
        onChange={toggleMode}
      />
      <label htmlFor="readMode">Read</label>
      <input
        type="radio"
        id="editMode"
        name="mode"
        value="Edit"
        checked={mode === 'Edit'}
        onChange={toggleMode}
      />
      <label htmlFor="editMode">Edit</label>
    </div>
    <Table bordered hover>
      {/* Table header */}
      <thead>
        <tr> 
          <th>Name</th>
          <th>Category</th>
          <th>Price</th>
          <th>Cost</th>
          <th>Discount</th>
          <th>Quantity</th>
          <th>Last Ordered</th>
          <th>Supplier</th>
          {/* Display delete and edit icons if in Edit mode */}
          {mode === 'Edit' && <th>Actions</th>}
        </tr>
      </thead>

      {/* Table body */}
      <tbody>
        {
          // Render every table entries as an object of InventoriesTableRow component
          props.tableEntries.map(entry => {
            return <InventoriesTableRow 
                      key={entry.inventoryID} 
                      inventoryID={entry.inventoryID}
                      storeID={entry.storeID}
                      productID={entry.productID}
                      productImg={entry.productImg}
                      productName={entry.productName}
                      categoryID={entry.categoryID}
                      category={entry.category}
                      cost={entry.cost}
                      sellPrice={entry.sellPrice}
                      quantity={entry.quantity}
                      discount={entry.discount}
                      lastOrderedDate={entry.lastOrderedDate}
                      orderedQuantity={entry.orderedQuantity}
                      supplierID={entry.supplierID}
                      supplier={entry.supplier}
                      openProductDetailModal={props.openProductDetailModal}
                      onDelete={props.deleteInventoryItem}
                      mode={mode}
                    />
          })
        }
      </tbody>
    </Table>
    </div>
  );

}

export default InventoriesTable