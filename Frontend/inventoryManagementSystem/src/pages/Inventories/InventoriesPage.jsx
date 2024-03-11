/**
 * @file The landing page for merchant users, which shows all the inventories in a given store
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

// Internal imports
import StoreSwitcher from '../../components/StoreSwitcher';
import InventoriesTable from './InventoriesTable';

// CSS imports
import "../../App.css"
import "./InventoriesPage.css"

function InventoriesPage() {
  
  return (
    <div className="inventories-page-pane">
      <StoreSwitcher />

      {/* Use React-Bootstrap to correctly layout the table and side panels, make sure that the
          table takes the left 10/12 and the panels takes the right 2/12 */}
      <Container>
        <Row>
          <Col md={10}>
            <InventoriesTable />
          </Col>

          <Col md={2}>
            <p>My side panels placeholder</p>
          </Col>
        </Row>
      </Container>

    </div>
  );
}

export default InventoriesPage