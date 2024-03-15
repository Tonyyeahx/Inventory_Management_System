/**
 * @file A pop-up modal for showing the product detail
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useState} from 'react'
import Modal from 'react-bootstrap/Modal';
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { Image } from 'react-bootstrap';

function ProductDetailModal(props) {

  // Use && to ensure that we are not trying access a null 'props.displayContent' object.
  // If the left of the '&&' operator is null, the content on the right will not be rendered, 
  // avoiding accessing things like null.productName or null.productImg, causing a crash
  return props.displayContent && (
    <Modal centered size='lg' show={props.show} onHide={props.handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>
          Product Detail - {props.displayContent.productName}
        </Modal.Title>
      </Modal.Header>

      <Modal.Body>
        {/* Use a React-Bootstrap to correctly layout the modal, so that the image will occupy the
            left 50% and the product information will occupy the right 50% */}
        <Container>
          <Row>
            {/* Used a Bootstrap's flexbox utilities 'd-flex' to align content at the center */}
            <Col className="d-flex justify-content-center">
              <Image fluid src={props.displayContent.productImg}/>
            </Col>

            <Col className="d-flex justify-content-center">
              {/* Use a table to show the product's detail */}
              <Table striped borderless hover>
                <tbody>
                  <tr>
                    <th>Product Name</th>
                    <td>{props.displayContent.productName}</td>
                  </tr>

                  <tr>
                    <th>Product ID</th>
                    <td>{props.displayContent.productID}</td>
                  </tr>

                  <tr>
                    <th>Inventory ID</th>
                    <td>{props.displayContent.inventoryID}</td>
                  </tr>

                  <tr>
                    <th>Store ID</th>
                    <td>{props.displayContent.storeID}</td>
                  </tr>

                  <tr>
                    <th>Category</th>
                    <td>{props.displayContent.category}</td>
                  </tr>

                  <tr>
                    <th>Category ID</th>
                    <td>{props.displayContent.categoryID}</td>
                  </tr>

                  <tr>
                    <th>Cost</th>
                    <td>{props.displayContent.cost}</td>
                  </tr>

                  <tr>
                    <th>Sell Price</th>
                    <td>{props.displayContent.sellPrice}</td>
                  </tr>

                  <tr>
                    <th>Discount</th>
                    <td>{props.displayContent.discount}</td>
                  </tr>

                  <tr>
                    <th>Remaining Quantity</th>
                    <td>{props.displayContent.quantity}</td>
                  </tr>

                  <tr>
                    <th>Ordered Quantity</th>
                    <td>{props.displayContent.orderedQuantity}</td>
                  </tr>

                  <tr>
                    <th>Last Ordered Date</th>
                    <td>{props.displayContent.lastOrderedDate}</td>
                  </tr>

                  <tr>
                    <th>Supplier</th>
                    <td>{props.displayContent.supplier}</td>
                  </tr>

                  <tr>
                    <th>Supplier ID</th>
                    <td>{props.displayContent.supplierID}</td>
                  </tr>
                </tbody>
              </Table>
            </Col>
          </Row>
        </Container>
      </Modal.Body>

    </Modal>
  )
}

export default ProductDetailModal