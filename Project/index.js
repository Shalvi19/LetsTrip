const admin = require('./node_modules/firebase-admin');
const serviceAccount = require("./letstrip-6e8e6-firebase-adminsdk-7jdom-d11c8f0a41.json");
const data = require("./Food1.json");
const collectionKey = "Food1"; //name of the collection
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://letstrip-6e8e6.firebaseio.com"
});
const firestore = admin.firestore();
const settings = {timestampsInSnapshots: true};
firestore.settings(settings);
if (data && (typeof data === "object")) {
Object.keys(data).forEach(docKey => {
 firestore.collection(collectionKey).doc(docKey).set(data[docKey]).then((res) => {
    console.log("Document " + docKey + " successfully written!");
}).catch((error) => {
   console.error("Error writing document: ", error);
});
});
}