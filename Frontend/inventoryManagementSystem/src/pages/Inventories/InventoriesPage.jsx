/**
 * @file The landing page for merchant users, which shows all the inventories in a given store
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, { useState, useEffect } from 'react'
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

// Internal imports
import StoreSwitcher from '../../components/StoreSwitcher';
import InventoriesTable from './InventoriesTable';
import createDummyGroceries from "../../utils/createDummyGroceries.js"

// CSS imports
import "../../App.css"
import "./InventoriesPage.css"

function InventoriesPage() {

  // Holds all inventories that satisfy the filter constrains (currently category and supplier) in
  // the current store
  const [inventories, setInventories] = useState([]);

  // Fetch the inventories from the API (in the future) and store them into the 'inventories' 
  // variable, or load dummy data before the integration phase
  const fetchInventories = () => {
    // TODO: Set inventories using real data fetched from the 'inventories' API endpoint
    setInventories(createDummyGroceries())
  }

  // Fetch inventories when the page is reload
  useEffect(fetchInventories, []);
  
  return (
    <div className="inventories-page-pane">
      <StoreSwitcher />

      {/* Use React-Bootstrap to correctly layout the table and side panels, make sure that the
          table takes the left 10/12 and the panels takes the right 2/12 */}
      <Container>
        <Row>
          <Col md={10}>
            {/* Ask the table to show all inventories from this store */}
            <InventoriesTable tableEntries={inventories} />
          </Col>

          <Col md={2}>
            <p>My side panels placeholder</p>
            <div className="mb-2"><Button variant='primary'>+</Button></div>
            <div className="mb-2"><Button variant='secondary'>-</Button></div>
          </Col>
        </Row>
      </Container>

    </div>
  );
}

export default InventoriesPage