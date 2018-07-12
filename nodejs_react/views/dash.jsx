var React = require('react');
var createReactClass = require('create-react-class');
var axios = require('axios');

module.exports = createReactClass({
	displayName: 'Index',
	getInitialState: function() {
		return {
			map: ""
		};
	},
	/*componentDidMount: function() {
		axios.get("http://localhost:3000/api/dash")
			.then((result) => {
				this.setState({map: result.data.msg});
			})
	},*/
	render: function() {
		return(
			<div>
				<p>Current: <strong>Index</strong></p>
				<p>{this.state.map}</p>
			</div>
		);
	}
});