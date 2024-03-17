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
import Form from 'react-bootstrap/Form'

// Internal imports
import StoreSwitcher from '../../components/StoreSwitcher';
import InventoriesTable from './InventoriesTable';
import ProductDetailModal from './ProductDetailModal.jsx';
import createDummyGroceries from "../../utils/createDummyGroceries.js"

// CSS imports
import "../../App.css"
import "./InventoriesPage.css"

function InventoriesPage() {

  // Holds all inventories that satisfy the filter constrains (currently category and supplier) in
  // the current store
  const [inventories, setInventories] = useState([]);

  // A boolean state variable controls if the ProductDetailModal should be shown or not
  const [showProdDetailModal, setShowProdDetailModal] = useState(false)

  // What to display in the ProductDetailModal when it's opened
  const [prodDetailDisplayContent, setProdDetailDisplayContent] = useState()

  // Determines what feature/functionality we will be searching by?
  const [searchCriteria, setSearchCriteria] = useState("productName"); // Default search criteria

  // Search bar state for inventories that holds the current search input of user
  const [searchValue, setSearchValue] = useState("") //search bar 1

  // Allows User to Reset the Search state so that Default Inventories apge loaded
  const [resetButton, setResetButton] = useState(false)

  /**
   * Fetch the inventories from the API (in the future) and store them into the 'inventories' 
   * variable, or load dummy data before the integration phase
   */
  const fetchInventories = () => {
    // TODO: Set inventories using real data fetched from the 'inventories' API endpoint
    setInventories(createDummyGroceries())
  }

  const resetSearch = () => {
    setSearchValue("")
    setSearchCriteria("productName")
    fetchInventories()
  }

  // Fetch inventories when the page is reload
  useEffect(fetchInventories, []);

  useEffect(() => {
    setResetButton(false)
    let data = []
    createDummyGroceries().forEach(inventory => {
      let valueMatch = inventory[searchCriteria].toLowerCase().includes(searchValue.toLowerCase())

      if (valueMatch){
        data.push(inventory)
      }
    })

    setInventories(data)

  }, [searchValue, searchCriteria])
  // Reset the search when resetButton state changes
  useEffect(() => {
    resetSearch(); 
  }, [resetButton]);

  /**
   * Open a product detail modal with specified product information in the 'entity' argument.
   * This function is passed 
   * @param {*} entity information about the grocery product to be displayed
   */ 
  const openProductDetailModal = (entity) => {
    console.log("openProductDetailModal() function called with " + entity)
    setProdDetailDisplayContent(entity)
    setShowProdDetailModal(true)
  }

  const hideProductDetailModal = () => {
    setShowProdDetailModal(false)

  }

  const handleResetButtonClick = () => {
    setResetButton(true);
  }
  
  return (
    <div className="inventories-page-pane">
      {/* A store switcher to switch between different stores */}
      <StoreSwitcher />
      <br></br>
      {/* Use React-Bootstrap to correctly layout the table and side panels, make sure that the
          table takes the left 10/12 and the panels takes the right 2/12. 
          Add 'fluid' so that this container can have a max-width of 100%, taking the entire width
          of the Inventories Page */}
      <Container fluid>
        <Row>
          <Col md={10}>
            {/* Ask the table to show all inventories from this store */}
            <InventoriesTable 
              tableEntries={inventories} 
              openProductDetailModal={openProductDetailModal}
            />
          </Col>

          <Col md={2}>
            <div>
              <Form>
              <Form.Group>
                    <Form.Label htmlFor="searchInventoryCriteria">I want to search by:</Form.Label>
                    <Form.Control as="select" id="searchInventoryCriteria" value={searchCriteria} onChange={(e) => setSearchCriteria(e.target.value)}>
                      <option value="productID">Product ID</option>
                      <option value="productName">Product Name</option>
                      <option value="category">Category</option>
                      <option value="categoryID">Category ID</option>
                      <option value="supplier">Supplier</option>
                      <option value="supplierID">Supplier ID</option>
                    </Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="searchInventoryName">Inventory Name</Form.Label>
                <Form.Control id="searchInventoryName" value={searchValue} onChange={
                        (e) => setSearchValue(e.target.value)
                        }/>
                <br></br>
              </Form.Group>
                <Button variant="primary" onClick={handleResetButtonClick}>Reset Search</Button> 
              </Form>
              </div>
            <br></br>  
          </Col>
        </Row>
        <Row>
          <Col md={10}></Col>
          <Col md={2}>
            <div className="mb-2"><Button variant='primary'>New Inventory Item</Button></div>
            <div className="mb-2"><Button variant='secondary'>- Item</Button></div>
          </Col>
        </Row>
      </Container>

      {/* Attach modals that could be show to the React DOM */}
      <ProductDetailModal 
        show={showProdDetailModal} 
        handleClose={hideProductDetailModal} 
        displayContent={prodDetailDisplayContent}
      />
    </div>
  );
}

export default InventoriesPage
