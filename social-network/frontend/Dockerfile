FROM node:17-alpine3.12
COPY package.json .
COPY package-lock.json .
RUN npm install # -g npm@8.9.0
COPY . .
EXPOSE 3000
CMD ["npm", "start"]
# in terminal type
# docker build -t react-ui-docker:0.0.1 .