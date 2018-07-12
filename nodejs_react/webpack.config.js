module.exports = {
	entry: './client.js',
	output: {
		filename: 'bundle.js',
		path: 'public'
	},
	module: {
		loaders: [
			{
				test: /\.jsx$/,
				exclude: /node_modules/,
				loader: 'babel-loader',
				query: {
					presets: ['react']
				}
			},
			{ test: /\.(png|jpg|jpeg|gif|svg)$/, loader: "url-loader?limit=100000" },
  			{ test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/, loader: "url-loader?limit=10000&minetype=application/font-woff" },
  			{ test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/, loader: "file-loader" }
		]
	}
}
