/**
 * @file A pop-up modal for showing the product detail
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useState} from 'react'
import Modal from 'react-bootstrap/Modal';
import Container from 'react-bootstrap/Container';
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
            <Col>
              hello right
            </Col>
          </Row>
        </Container>
      </Modal.Body>

    </Modal>
  )
}

export default ProductDetailModal