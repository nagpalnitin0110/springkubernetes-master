##########SpringBootTech############



3. http://0.0.0.0:9080/api/getHello
Method Type : GET

4. http://0.0.0.0:9080/api/getFibonacciSeries
Method Type : GET

Docker Build :
docker build -t springboottech .
docker run -it -d --name SpringBootTechAnalysis -p 9080:9080 springboottech




2. Create OCP new-app 
oc new-app ubi8-openjdk-11:1.3~http://10.*.*.*:8080/scm/dev/dev_3scale.git

Output----
--> Found image 9be97c3 (7 weeks old) in image stream "openshift/ubi8-openjdk-11" under tag "1.3" for "ubi8-openjdk-11:1.3"

    Java Applications
    -----------------
    Platform for building and running plain Java applications (fat-jar and flat classpath)

    Tags: builder, java

    * A source build using source code from http://10.240.34.16:7990/scm/dev/dev_3scale.git will be created
      * The resulting image will be pushed to image stream tag "dev3scale:latest"
      * Use 'oc start-build' to trigger a new build

--> Creating resources ...
    imagestream.image.openshift.io "dev3scale" created
    buildconfig.build.openshift.io "dev3scale" created
    deployment.apps "dev3scale" created
    service "dev3scale" created
--> Success
    Build scheduled, use 'oc logs -f buildconfig/dev3scale' to track its progress.
    Application is not exposed. You can expose services to the outside world by executing one or more of the commands below:
     'oc expose service/dev3scale'
    Run 'oc status' to view your app.

3. Get Pods details
#oc get pods
NAME                READY   STATUS     RESTARTS   AGE
dev3scale-1-build   0/1     Init:0/2   0          9s

[AppADM@D1PRVRRPGDA17 dev_3scale]$ oc get pods
NAME                         READY   STATUS      RESTARTS   AGE
dev3scale-1-build            0/1     Completed   0          9m57s
dev3scale-5c989bb4b7-pc46q   1/1     Running     0          115s

4. Add port tcp 9080 into service
oc edit svc dev3scale

 ports:
  - name: 8080-tcp
    port: 8080
    protocol: TCP
    targetPort: 8080
  - name: 9080-tcp
    port: 9080
    protocol: TCP
    targetPort: 9080

5. Expose route for sample route
oc expose svc dev3scale

edit the tcp port in route
oc edit route 

spec:
  host: springtest-test2.apps.shared-na46.openshift.opentlc.com
  port:
    targetPort: 9080-tcp
  tls:
    insecureEdgeTerminationPolicy: Redirect
    termination: edge
  to:
    kind: Service
    name: dev3scale
    weight: 100
  wildcardPolicy: None

