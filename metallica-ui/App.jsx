import React from 'react';
import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import Avatar from 'material-ui/Avatar';
import {Tabs, Tab} from 'material-ui/Tabs';

const style = {margin: 25};
const labelStyle = {color: 'white'};

const styles = {
  headline: {
    fontSize: 24,
    paddingTop: 16,
    marginBottom: 12,
    fontWeight: 400,
  },
};

const Logged = (props) => (
	<div>
	<span style={labelStyle}>UserName</span>
	<Avatar size={30} style={style}>
	  A
	</Avatar>
	</div>
);

Logged.muiName = 'IconMenu';
class App extends React.Component {
  render() {
    return (
	<MuiThemeProvider>
      <div>
        <AppBar
          title="Metallica App"
          iconElementRight={<Logged />}
        />
      </div>
	  <div>
	  
	  <Tabs style={}>
    <Tab label="Trades" >
      <div>
        <h2 style={styles.headline}>Trades</h2>
      </div>
    </Tab>
	<Tab label="Transfer" >
      <div>
        <h2 style={styles.headline}>Transfer</h2>
      </div>
    </Tab>
	<Tab label="Transport" >
      <div>
        <h2 style={styles.headline}>Transport</h2>
      </div>
    </Tab>
	</Tabs>
	  
	  
	  </div>
	  </MuiThemeProvider>
    );
  }
}

export default App;