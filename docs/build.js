/**
 * Created by Capricorncd.
 * User: https://github.com/capricorncd
 * Date: 2019/03/31 20:15
 */
const fs = require('fs-extra')

try {
    fs.removeSync('./docs')
    fs.moveSync('./_book', './docs')
} catch (e) {
    console.log(e)
}
