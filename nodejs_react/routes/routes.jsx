var React = require('react');
var ReactRouter = require('react-router');
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var browserHistory = ReactRouter.browserHistory;

if (typeof window === 'object') {
	function createElement(Component, props) {
		return <Component {...props} custom={window.PROPS} />;
	}
}

module.exports = (
	<Router history={browserHistory} createElement={createElement}>
		<Route path='/dash' component={require('../views/common.jsx')}>
			<IndexRoute component={require('../views/dash.jsx')} />
			<Route path='about' component={require('../views/About.jsx')} />
		</Route>
		<Route path="/login" component={require('../views/login.jsx')}>
			<IndexRoute component={require('../views/customer_login.jsx')} />
			<Route path='seller' component={require('../views/seller_login.jsx')} />
		</Route>
		<Route path="/mystore" component={require('../views/mystore.jsx')}>
			<IndexRoute component={require('../views/test.jsx')} />
		</Route>
	</Router>
);
