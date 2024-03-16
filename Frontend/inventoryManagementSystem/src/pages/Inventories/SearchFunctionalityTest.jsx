import React from 'react';
import { render, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import InventoriesPage from './InventoriesPage';

describe('InventoriesPage component', () => {
  test('renders search functionality', () => {
    const { getByLabelText, getByText } = render(<InventoriesPage />);
    
    // Check if search criteria dropdown exists
    const searchCriteriaDropdown = getByLabelText('I want to search by:');
    expect(searchCriteriaDropdown).toBeInTheDocument();
    
    // Check if inventory name input field exists
    const inventoryNameInput = getByLabelText('Inventory Name');
    expect(inventoryNameInput).toBeInTheDocument();
    
    // Check if reset search button exists
    const resetSearchButton = getByText('Reset Search');
    expect(resetSearchButton).toBeInTheDocument();
  });

  test('search functionality works', async () => {
    const { getByLabelText, getByText } = render(<InventoriesPage />);
    
    // Simulate user input in search criteria dropdown
    const searchCriteriaDropdown = getByLabelText('I want to search by:');
    fireEvent.change(searchCriteriaDropdown, { target: { value: 'productName' } });

    // Simulate user input in inventory name input field
    const inventoryNameInput = getByLabelText('Inventory Name');
    fireEvent.change(inventoryNameInput, { target: { value: 'apple' } });
    
    // Simulate click on reset search button
    const resetSearchButton = getByText('Reset Search');
    fireEvent.click(resetSearchButton);

    // Ensure that search criteria and inventory name input are reset
    await waitFor(() => {
      expect(searchCriteriaDropdown.value).toBe('productName');
      expect(inventoryNameInput.value).toBe('');
    });
  });
});
