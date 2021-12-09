import br.eti.elio.Constants

// vars/sayHello.groovy
def call(String name = 'human') {
  // Any valid steps can be called from this code,
  // just like in other Scripted Pipeline
  echo "Hello, ${name}."
  echo "${Constants.MS_TEAMS_SENDING_MESSAGE}"
}
