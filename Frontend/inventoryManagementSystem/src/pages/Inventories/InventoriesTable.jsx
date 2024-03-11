/**
 * @file The inventories table shows all inventories matching filter conditions (store, category, 
 *    supplier)
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'
import Table from 'react-bootstrap/Table';

// CSS imports
import "../../App.css"

function InventoriesTable() {
  return (
    <Table striped bordered hover>
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
    </Table>
  );

}

export default InventoriesTable