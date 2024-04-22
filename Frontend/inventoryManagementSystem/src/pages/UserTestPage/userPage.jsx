import React, { useState } from 'react';
import './userPage.css';
import MerchantNavbar from '../../components/MerchantNavbar';

function UserTestPage() {
  const [products, setProducts] = useState([
    { id: 1, name: 'Product 1', price: 10, quantity: 0 },
    { id: 2, name: 'Product 2', price: 20, quantity: 0 },
    { id: 3, name: 'Product 3', price: 30, quantity: 0 },
    { id: 4, name: 'Product 4', price: 15, quantity: 0 },
    { id: 5, name: 'Product 5', price: 25, quantity: 0 },
    { id: 6, name: 'Product 6', price: 35, quantity: 0 }
  ]);

  const handleBuy = () => {
    const selectedProducts = products.filter(product => product.quantity > 0);
    if (selectedProducts.length === 0) {
      alert("Please select at least one item.");
    } else {
      const quantityTotal = selectedProducts.reduce((total, product) => total + product.quantity, 0);
      const items = selectedProducts.map(product => `${product.quantity} ${product.name}`).join(', ');
      alert(`You just bought ${quantityTotal} ${quantityTotal > 1 ? 'items' : 'item'}: ${items}.`);
      setProducts(products.map(product => ({ ...product, quantity: 0 })));
    }
  };

  const handleIncrement = (id) => {
    setProducts(products.map(product => {
      if (product.id === id) {
        return { ...product, quantity: product.quantity + 1 };
      }
      return product;
    }));
  };

  const handleDecrement = (id) => {
    setProducts(products.map(product => {
      if (product.id === id && product.quantity > 0) {
        return { ...product, quantity: product.quantity - 1 };
      }
      return product;
    }));
  };

  return (
    <>
      {/* The side navbar */}
      <MerchantNavbar />
    
      <div className="product-container">
        <h1 className="page-title">Shopping Page</h1>
        <div className="product-list">
          {products.map(product => (
            <div key={product.id} className="product-item">
              <h3>{product.name}</h3>
              <p>Price: ${product.price}</p>
              <div className="quantity-controls">
                <button onClick={() => handleDecrement(product.id)}>-</button>
                <p className="quantity">{product.quantity}</p>
                <button onClick={() => handleIncrement(product.id)}>+</button>
              </div>
              <button className="buy-button" onClick={() => alert(`You just bought ${product.quantity} ${product.quantity > 1 ? 'items' : 'item'}: ${product.name}.`)}>Buy</button>
            </div>
          ))}
        </div>
        <button className="buy-button" onClick={handleBuy}>Buy Selected</button>
      </div>
    </>
  );
}

export default UserTestPage;