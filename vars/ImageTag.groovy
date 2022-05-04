//   def version = readFile('VERSION')
//   def versions = version.split('\\.')
//   def major = versions[0]
//   def minor = versions[0] + '.' + versions[1]
//   def patch = version.trim()

def call(name){
  echo "hello ${name} how are you"
}
