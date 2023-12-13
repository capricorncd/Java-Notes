/**
 * Created by Capricorncd.
 * https://github.com/capricorncd
 * Date: 2023/12/12 20:42:46 (GMT+0900)
 * 
 * node version: v20.10.0
 */
const fs = require('fs')
const path = require('path')
const config = require('../pages/.vuepress/config')

const BASE_PATH = config.base.replace(/\/+$/, '')
const REG_IMG = /src="(\/img\/[^"]+)"/g

function getHtmlFiles(filePath, result = []) {
  if (fs.existsSync(filePath)) {
    const stat = fs.statSync(filePath)
    if (stat.isDirectory()) {
      fs.readdirSync(filePath).forEach(file => {
        getHtmlFiles(path.join(filePath, file), result)
      })
    } else if (stat.isFile()) {
      if (path.extname(filePath) === '.html') {
        result.push(filePath)
      }
    }
  } 
  return result
}

function fixPublicFilesPath(htmlFile) {
  const html = fs.readFileSync(htmlFile, 'utf-8')
  // has img
  if (REG_IMG.test(html)) {
    const newHtml = html.replace(REG_IMG, `src="${BASE_PATH}$1"`)
    fs.writeFileSync(htmlFile, newHtml, 'utf-8')
    console.log('fix public file path:', htmlFile)
  }
}

function main() {
  const docsDir = path.join(path.resolve(__dirname, '../docs'))
  const htmlList = getHtmlFiles(docsDir)
  // console.log(htmlList)
  htmlList.forEach(fixPublicFilesPath)
}

main()