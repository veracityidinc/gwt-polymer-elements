#!/bin/bash
# @author bp

set -e

echo "1. Cleaning previous run footprints..."
[ -d "bower_components" ] && rm -r bower_components
[ -d "src" ] && rm -r src
# [ -f "package-lock.json" ] && rm package-lock.json

echo "2. Running bower install --production"
bower install --production

echo "3. Running npm install"
npm install