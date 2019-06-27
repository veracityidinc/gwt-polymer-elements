
echo "1. Cleaning previous run footprints..."
rm bower_components -Force -Recurse -ErrorAction SilentlyContinue
rm src -Force -Recurse -ErrorAction SilentlyContinue
rm package-lock.json -Force -ErrorAction SilentlyContinue

echo "2. Running bower install --production"
bower install --production

echo "3. Running npm install"
npm install