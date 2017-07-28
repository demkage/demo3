const webpack = require('webpack');
const path = require('path');

const ExtractTextPlugin = require('extract-text-webpack-plugin');

const TARGET = process.env.npm_lifecycle_event;

const SRC = path.resolve(__dirname, 'src/main/react/static');
const DEST = path.resolve(__dirname, 'src/main/resources/static');

const sourcePath = path.resolve(__dirname, 'src/main/react/static');

const config = {
    context: SRC,
    entry: {
        "index": "./index",
        "client": "./client.render",
        "server": "./server.render"
    },
    resolve: {
        extensions: ['.js', '.jsx', '.less']
    },
    output: {
        path: DEST,
        filename: '[name].bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                use: [ 'eslint-loader' ],
                enforce: 'pre'
            },
            {
                test: /\.jsx?$/,
                use: [ 'babel-loader' ],
                exclude: /node_modules/
            },
            {
                test: /\.(?:css|less)$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: 'css-loader!less-loader'
                })
            },
            {
                exclude: [
                    /\.html$/,
                    /\.(js|jsx)$/,
                    /\.css$/,
                    /\.json$/,
                    /\.bmp$/,
                    /\.gif$/,
                    /\.jpe?g$/,
                    /\.png$/,
                ],
                loader: require.resolve('file-loader'),
                options: {
                    name: 'static/media/[name].[hash:8].[ext]',
                },
            },
            // "url" loader works just like "file" loader but it also embeds
            // assets smaller than specified size as data URLs to avoid requests.
            {
                test: [/\.bmp$/, /\.gif$/, /\.jpe?g$/, /\.png$/],
                loader: require.resolve('url-loader'),
                options: {
                    limit: 10000,
                    name: 'static/media/[name].[hash:8].[ext]',
                },
            },
        ]
    },
    plugins: [
        new webpack.LoaderOptionsPlugin({
            minimize: true,
            debug: false
        }),
        new ExtractTextPlugin({
            filename: 'bundle.css'
            // allChunks: true,
            // disabled: TARGET === 'build' || TARGET === 'debug'
        })
    ],
    devServer: {
        port: 9090,
        contentBase: 'src/main/resources/static',
        publicPath: 'http://localhost:9090/app/'
    },
    devtool: TARGET === 'build' ? 'source-map' : 'eval'
};

if (TARGET === 'build') {
    config.plugins.push(
        new webpack.DefinePlugin({
            'process.env': {
                NODE_ENV: '"production"'
            }
        }),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false,
                screw_ie8: true,
                conditionals: true,
                unused: true,
                comparisons: true,
                sequences: true,
                dead_code: true,
                evaluate: true,
                if_return: true,
                join_vars: true,
            },
            output: {
                comments: false
            },
            sourceMap: true
        })
    );
}

module.exports = config;