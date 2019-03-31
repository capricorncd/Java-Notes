/**
 * Created by Capricorncd.
 * User: https://github.com/capricorncd
 * Date: 2019/03/31 20:15
 */
const fs = require('fs-extra')
const path = require('path')

try {
    fs.removeSync(path.resolve(__dirname, '../docs'))
    fs.renameSync(path.resolve(__dirname, '../_book'), path.resolve(__dirname, '../docs'))
} catch (e) {
    console.log(e)
}
