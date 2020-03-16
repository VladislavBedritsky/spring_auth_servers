openssl genrsa -out jwt.pem 2048

#private key
openssl rsa -in jwt.pem

#public key
openssl rsa -in jwt.pem -pubout