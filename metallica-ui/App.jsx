import React from 'react';
import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import Avatar from 'material-ui/Avatar';
import {Tabs, Tab} from 'material-ui/Tabs';
import MenuItem from 'material-ui/MenuItem';
import DropDownMenu from 'material-ui/DropDownMenu';
import DatePicker from 'material-ui/DatePicker';
import Checkbox from 'material-ui/Checkbox';
import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar';
import Paper from 'material-ui/Paper';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';

import {
Table,
TableBody,
TableHeader,
TableHeaderColumn,
TableRow,
TableRowColumn,
} from 'material-ui/Table';
    
const style = {margin: 25};
const labelStyle = {color: 'white'};

const paperStyle = {
height: 160,
width: '98%',
margin: 10,
display: 'inline-block',
};

const paperForTable = {
height: '100%',
margin: 10,
display: 'inline-block',
};

const paperForSidePanel = {
height: '100%',
margin: 10,
display: 'inline-block',
};

const styles = {
headline: {
fontSize: 24,
paddingTop: 16,
marginBottom: 12,
fontWeight: 400,
},
searchBar: {
display:'inline-block',
width:'auto'
},
gridList: {
width: '60%',
overflowY: 'auto',
}
};

const Logged = (props) => (
<div>
   <span style={labelStyle}>UserName</span>
   <Avatar size={30} style={style}>
      A
   </Avatar>
</div>
);

const tableData = [
{
"tradeId": 1101,
"side": "BUY",
"quanity": 50,
"price": 100,
"tradeDate": 61469260200000,
"status": "OPEN",
"commodity": {
"code": "AL",
"description": "Aluminum"
},
"counterParty": {
"code": "Lorem",
"description": "Lorem"
},
"location": {
"code": "LN",
"description": "London"
}
},
{
"tradeId": 1102,
"side": "SELL",
"quanity": 50,
"price": 100,
"tradeDate": 61469260200000,
"status": "NOMINATED",
"commodity": {
"code": "AL",
"description": "Aluminum"
},
"counterParty": {
"code": "Lorem",
"description": "Lorem"
},
"location": {
"code": "LN",
"description": "London"
}
},
{
"tradeId": 1103,
"side": "SELL",
"quanity": 30,
"price": 125,
"tradeDate": 61469346600000,
"status": "OPEN",
"commodity": {
"code": "AL",
"description": "Aluminum"
},
"counterParty": {
"code": "Lorem",
"description": "Lorem"
},
"location": {
"code": "LN",
"description": "London"
}
}
];
Logged.muiName = 'IconMenu';

class App extends React.Component {
    
    
constructor() {
    super();
    this.state={counterparties:[],commodities:[],locations:[]};
}

componentDidMount(){    

 fetch(`http://localhost:8090/counterparties`)
.then(result=>result.json())
.then(counterparties=>this.setState({counterparties}))
  
fetch(`http://localhost:8090/locations`)
.then(result=>result.json())
.then(locations=>this.setState({locations}))
  
fetch(`http://localhost:8090/commodities`)
.then(result=>result.json())
.then(commodities=>this.setState({commodities}))

}
    
render() {
return (
<MuiThemeProvider>
   <div>
      <div style={{height: '14vh'}}>
         <AppBar title="Metallica App" iconElementRight={
         <Logged />
         } style={{backgroundColor:'#BFBFBF'}}/>
      </div>
      <div style={{height: '86vh'}}>
         <Tabs inkBarStyle={{backgroundColor:'#BFBFBF'}} style={{backgroundColor:'#ffffff'}} contentContainerStyle={{backgroundColor:'#F5F5F5'}} >
            <Tab label="Trades" style={{backgroundColor:'#ffffff'}} >
               <Paper style={paperStyle} zDepth={1} >
                  <div class="container" style={{margin:'10px'}}>
                     <form>
                        <div class="row">
                           <div class="col-sm-4">
                              <div class="form-group">
                                 <label>Trade Date</label>
                                 <div>
                                    <DatePicker onChange={this.handleChange} style={styles.searchBar} textFieldStyle={{width:'130px'}}/>
                                    <label style={{paddingRight:'10px',paddingLeft:'10px'}}>to</label>
                                    <DatePicker onChange={this.handleChange} style={styles.searchBar} textFieldStyle={{width:'130px'}}/>
                                 </div>
                              </div>
                           </div>
                           <div class="col-sm-2">
                              <div class="form-group">
                                 <label>Commodity</label>
                                 <div>
                                    <DropDownMenu value={1} onChange={this.handleChange} style={{height:'40px'}}>
                                        {this.state.commodities.map(commoditie=><MenuItem value={1} primaryText={commoditie.code}/>)}
                                    </DropDownMenu>
                                 </div>
                              </div>
                           </div>
                           <div class="col-sm-2">
                              <div class="form-group">
                                 <label>Commodity</label>
                                 <div style={{marginTop:'15px'}}>
                                    <Checkbox name="StylesOverridingInlineExample" label="Buy" style={styles.searchBar}  inputStyle= {styles.searchBar}/>
                                    <Checkbox name="StylesOverridingInlineExample" label="Sell" style={styles.searchBar}  inputStyle= {styles.searchBar}/>
                                 </div>
                              </div>
                           </div>
                           <div class="col-sm-2">
                              <div class="form-group">
                                 <label>Counterparty</label>
                                 <div>
                                    <DropDownMenu value={1} onChange={this.handleChange} style={{height:'40px'}}>
                                       {this.state.counterparties.map(counterparty=><MenuItem value={1} primaryText={counterparty.code}/>)}
                                    </DropDownMenu>
                                 </div>
                              </div>
                           </div>
                           <div class="col-sm-2">
                              <div class="form-group">
                                 <label>Location</label>
                                 <div>
                                    <DropDownMenu value={1} onChange={this.handleChange} style={{height:'40px'}}>
                                       {this.state.locations.map(location=><MenuItem value={1} primaryText={location.code}/>)}
                                    </DropDownMenu>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                  <div class="form-group" style={{float:'right'}}>
                                    <RaisedButton label="Clear" style={{marginLeft: 12}}/>
                                    <RaisedButton label="Search" style={{marginLeft: 12}}/>
                                  </div>
                            </div>
                        </div>
                     </form>
                  </div>
               </Paper>
               
                  
                     <Paper style={paperForTable} zDepth={1} class="col-sm-7" >
                        
                        <Table>
                           <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
                              <TableRow>
                                 <TableHeaderColumn>Trade Date</TableHeaderColumn>
                                 <TableHeaderColumn>Commodity</TableHeaderColumn>
                                 <TableHeaderColumn>Side</TableHeaderColumn>
                                 <TableHeaderColumn>Qty(MT)</TableHeaderColumn>
                                 <TableHeaderColumn>Price(/MT)</TableHeaderColumn>
                                 <TableHeaderColumn>Counterparty</TableHeaderColumn>
                                 <TableHeaderColumn>Location</TableHeaderColumn>
                              </TableRow>
                           </TableHeader>
                           <TableBody displayRowCheckbox={false}>
                              {tableData.map((data) => (
                              <TableRow key={data.tradeId}>
                                 >
                                 <TableRowColumn>{data.tradeDate}</TableRowColumn>
                                 <TableRowColumn>{data.commodity.code}</TableRowColumn>
                                 <TableRowColumn>{data.side}</TableRowColumn>
                                 <TableRowColumn>{data.quanity}</TableRowColumn>
                                 <TableRowColumn>{data.price}</TableRowColumn>
                                 <TableRowColumn>{data.counterParty.code}</TableRowColumn>
                                 <TableRowColumn>{data.location.code}</TableRowColumn>
                              </TableRow>
                              ))}
                           </TableBody>
                        </Table>
                           
                     </Paper>
                  
                     <Paper style={paperForSidePanel} zDepth={1} class="col-sm-4">
                        <form>
                           <div class="col-sm-1">
                              <DropDownMenu value={1} onChange={this.handleChange} style={styles.searchBar}>
                                 <MenuItem value={1} primaryText="AL" />
                              </DropDownMenu>
                           </div>
                        </form>
                     </Paper>
               
            </Tab>
            //Transfer Tab
            <Tab label="Transfers" style={{backgroundColor:'#ffffff'}} >
               <div>
                  <h2 style={styles.headline}>This is out of scope for Full Stack development Excerise</h2>
               </div>
            </Tab>
            //Transport Tab
            < Tab label = "Transports" style={{backgroundColor:'#ffffff'}} >
            <div>
               <h2 style={styles.headline}>This is out of scope for Full Stack development Excerise</h2>
            </div>
            </Tab>
         </Tabs>
      </div>
   </div>
</MuiThemeProvider>
);
}
}
export default App;