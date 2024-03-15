/**
 * @file The inventories table shows all inventories matching filter conditions (store, category, 
 *    supplier)
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useEffect, useState} from 'react'
import Table from 'react-bootstrap/Table';

// Internal imports
import InventoriesTableRow from './InventoriesTableRow';

// CSS imports
import "../../App.css"

function InventoriesTable(props) {

  return (
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
                    />
          })
        }
      </tbody>
    </Table>
  );

}

export default InventoriesTable