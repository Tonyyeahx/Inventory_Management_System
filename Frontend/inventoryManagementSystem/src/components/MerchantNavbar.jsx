/**
 * @file Created a side menubar / navbar for the merchant view users
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'
import { Sidebar, Menu, MenuItem, SubMenu} from 'react-pro-sidebar';

// Icon imports
import StoreOutlineIcon from 'mdi-react/StoreOutlineIcon';
import TruckCargoContainerIcon from 'mdi-react/TruckCargoContainerIcon';
import CogIcon from 'mdi-react/CogIcon';
import DevToIcon from 'mdi-react/DevToIcon';
import LogoutIcon from 'mdi-react/LogoutIcon';
import CartVariantIcon from 'mdi-react/CartVariantIcon';

// Internal imports
import teamLogo from "../assets/TeamLogo.png"

// CSS imports
import "../App.css"
import "./MerchantNavbar.css"

function MerchantNavbar() {
  return ( 
    // Used a div in order to extend the side menu bar from the top to the buttom of the screen
    <div className="side-menu-bar">

      <Sidebar backgroundColor='#ededed'>

        {/* Display project/team logo here in the top of the menu bar. Used a logo wrapper to make
            it align at the center */}
        <div className="logo-wrapper">
            <img src={teamLogo} className="logo" alt="React logo" />
        </div>

        {/* Start of the menu items */}
          <Menu>
              <MenuItem icon={<StoreOutlineIcon />}> Inventories </MenuItem>
              <MenuItem icon={<TruckCargoContainerIcon />}> Orders </MenuItem>
              <MenuItem icon={<DevToIcon />}> Menu 3 </MenuItem>
              <MenuItem icon={<DevToIcon />}> Menu 4 </MenuItem>
              <MenuItem icon={<CogIcon />}> Settings </MenuItem>
              <MenuItem icon={<LogoutIcon />}> Logout </MenuItem>
              <MenuItem icon={<CartVariantIcon />}> Consumer (Debug) </MenuItem>
          </Menu>
      </Sidebar>
    </div>
  );
}

export default MerchantNavbar