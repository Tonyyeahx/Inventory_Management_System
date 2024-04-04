/**
 * @file A pop-up modal for showing the product detail
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useState, useContext, useEffect} from 'react'

import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import Image from 'react-bootstrap/Image';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Spinner from 'react-bootstrap/Spinner';

// Internal imports
import ViewEditModeRadioButton from '../../components/ViewEditModeRadioButton';

// Context imports
import ViewModeContext from '../../context/ViewModeContext';

// CSS import
import "./ProductDetailModal.css"

function ProductDetailModal(props) {
  // Toggles between 'View' and 'Edit'
  const [viewEditMode, setViewEditMode] = useContext(ViewModeContext)

  // A flag indicating if the submitting is in progress. True when submitting, false when not.
  const [isSubmitting, setIsSubmitting] = useState(false)

  // When in edit mode, these state variables stores the (user edited) value of the entities of
  // this inventory
  const [editProductName, setEditProductName] = useState("")
  const [editProductID, setEditProductID] = useState("")
  const [editInventoryID, setEditInventoryID] = useState("")
  const [editStoreID, setEditStoreID] = useState("")
  const [editCategory, setEditCategory] = useState("")
  const [editCategoryID, setEditCategoryID] = useState("")
  const [editCost, setEditCost] = useState("")
  const [editSellPrice, setEditSellPrice] = useState("")
  const [editDiscount, setEditDiscount] = useState("")
  const [editQuantity, setEditQuantity] = useState("")
  const [editOrderedQuantity, setEditOrderedQuantity] = useState("")
  const [editLastOrderedDate, setEditLastOrderedDate] = useState("")
  const [editSupplier, setEditSupplier] = useState("")
  const [editSupplierID, setEditSupplierID] = useState("")
  const [editImage, setEditImage] = useState()

  useEffect(() => console.log(editImage),[editImage])

  // Update the value of the state variables when props arrives, avoiding to render null when the 
  // props hasn't arrived yet
  const syncEditValueWithDisplayValue = () => {
    // Checking if props.displayContent is null. Only assign the value when it's not null
    if (props.displayContent) {
      setEditProductName(props.displayContent.productName)
      setEditProductID(props.displayContent.productID)
      setEditInventoryID(props.displayContent.inventoryID)
      setEditStoreID(props.displayContent.storeID)
      setEditCategory(props.displayContent.category)
      setEditCategoryID(props.displayContent.categoryID)
      setEditCost(props.displayContent.cost)
      setEditSellPrice(props.displayContent.sellPrice)
      setEditDiscount(props.displayContent.discount)
      setEditQuantity(props.displayContent.quantity)
      setEditOrderedQuantity(props.displayContent.orderedQuantity)
      setEditLastOrderedDate(props.displayContent.lastOrderedDate)
      setEditSupplier(props.displayContent.supplier)
      setEditSupplierID(props.displayContent.supplierID)
    }
  }

  useEffect(syncEditValueWithDisplayValue, [props.displayContent])

  // A function use to submit the change to the server, also will close this modal and refresh the
  // inventory table to reflect the change
  const handleSubmit = () => {
    // Set isSubmitting to true to disable the controls and display the uploading animation
    setIsSubmitting(true)

    // TODO: API communication goes here

    // Send a alert to notify the user that submitting is done
    alert("Change submitted")
    setIsSubmitting(false)

    // Close the model and fetch the new inventory table from the server
    props.fetchInventories()
    props.handleClose()
  }


  // Use && to ensure that we are not trying access a null 'props.displayContent' object.
  // If the left of the '&&' operator is null, the content on the right will not be rendered, 
  // avoiding accessing things like null.productName or null.productImg, causing a crash
  return props.displayContent && (
    <Modal centered size='xl' show={props.show} onHide={props.handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>
          Product Detail - {props.displayContent.productName}
        </Modal.Title>
      </Modal.Header>

      <Modal.Body>
        {/* Use a React-Bootstrap to correctly layout the modal, so that the image will occupy the
            left 7/12 and the product information will occupy the right 5/12 */}
        <Container>
          <Row>
            {/* Used a Bootstrap's flexbox utilities 'd-flex' to align content at the center */}
            <Col md={7} className="d-flex flex-column justify-content-center">
              <Image src={props.displayContent.productImg} className='product-image'/>

              {
                // Show the file upload module only when in edit mode, hide it when is view mode
                viewEditMode == "Edit" && 
                  <>
                    <Form.Label>Upload New Images</Form.Label>
                    <Form.Control 
                      disabled={isSubmitting} 
                      type="file" 
                      onChange={e => setEditImage(e.target.files[0])}
                    />
                  </>
              }
            </Col>

            <Col md={5} className="d-flex flex-column justify-content-center">
              {/* To toggle between view mode and edit mode. In edit mode, the attributes for the 
                  inventories would be able to edit */}
              <ViewEditModeRadioButton />
              <br />

              <Form>
                {/* The purpose of this fieldset is disabling the Form Controls when submitting */}
                <fieldset disabled={isSubmitting}>

                  {/* Use a table to show the product's detail 
                      When in view mode, the table display the value 
                    */}
                  <Table striped borderless hover>
                    <tbody>
                      <tr>
                        <th>Product Name</th>
                        <td>
                          {
                            // Show the text only when in view mode, show the text in the edit box 
                            // when it's in edit mode
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editProductName} 
                                onChange={e => setEditProductName(e.target.value)}
                              />
                            :
                              props.displayContent.productName
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Product ID</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editProductID} 
                                onChange={e => setEditProductID(e.target.value)}
                              />
                            :
                              props.displayContent.productID
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Inventory ID</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editInventoryID} 
                                onChange={e => setEditInventoryID(e.target.value)}
                              />
                            :
                              props.displayContent.inventoryID
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Store ID</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editStoreID} 
                                onChange={e => setEditStoreID(e.target.value)}
                              />
                            :
                              props.displayContent.storeID
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Category</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editCategory} 
                                onChange={e => setEditCategory(e.target.value)}
                              />
                            :
                              props.displayContent.category
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Category ID</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editCategoryID} 
                                onChange={e => setEditCategoryID(e.target.value)}
                              />
                            :
                              props.displayContent.categoryID
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Cost $</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editCost} 
                                onChange={e => setEditCost(e.target.value)}
                              />
                            :
                              props.displayContent.cost
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Sell Price $</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editSellPrice} 
                                onChange={e => setEditSellPrice(e.target.value)}
                              />
                            :
                              props.displayContent.sellPrice
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Discount $</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editDiscount} 
                                onChange={e => setEditDiscount(e.target.value)}
                              />
                            :
                              props.displayContent.discount
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Remaining Quantity</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editQuantity} 
                                onChange={e => setEditQuantity(e.target.value)}
                              />
                            :
                              props.displayContent.quantity
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Ordered Quantity</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editOrderedQuantity} 
                                onChange={e => setEditOrderedQuantity(e.target.value)}
                              />
                            :
                              props.displayContent.orderedQuantity
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Last Ordered Date</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editLastOrderedDate} 
                                onChange={e => setEditLastOrderedDate(e.target.value)}
                              />
                            :
                              props.displayContent.lastOrderedDate
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Supplier</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editSupplier} 
                                onChange={e => setEditSupplier(e.target.value)}
                              />
                            :
                              props.displayContent.supplier
                          }
                        </td>
                      </tr>

                      <tr>
                        <th>Supplier ID</th>
                        <td>
                          {
                            viewEditMode == "Edit" 
                            ? 
                              <Form.Control 
                                size="sm"
                                value={editSupplierID} 
                                onChange={e => setEditSupplierID(e.target.value)}
                              />
                            :
                              props.displayContent.supplierID
                          }
                        </td>
                      </tr>
                    </tbody>
                  </Table>
                </fieldset>
              </Form>

              {
                // Display the submit and revert button only in edit mode
                viewEditMode == "Edit" && 
                // Use to apply the styling
                <div className="submit-revert-button">
                  <Button 
                    variant="secondary" 
                    disabled={isSubmitting}
                    onClick={syncEditValueWithDisplayValue}
                  > 
                    Revert Back
                  </Button>

                  <Button
                    disabled={isSubmitting}
                    onClick={handleSubmit}
                  > 
                    {
                      // When submitting, display the spinner animation and change title from 
                      // "Submit Edits" to "Submitting"
                      isSubmitting 
                        ? 
                          
                          <>
                            <Spinner
                              animation="grow"
                              size="sm"
                            />
                            Submitting...
                          </> 
                        : 
                          <>Submit Edits</>
                    }
                  </Button>

                </div>
              }

            </Col>
          </Row>
        </Container>
      </Modal.Body>

    </Modal>
  )
}

export default ProductDetailModal