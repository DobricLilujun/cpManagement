/**
 * TmriJaxRpcOutNewAccessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package test;

public class TmriJaxRpcOutNewAccessServiceLocator extends org.apache.axis.client.Service implements TmriJaxRpcOutNewAccessService {

    public TmriJaxRpcOutNewAccessServiceLocator() {
    }


    public TmriJaxRpcOutNewAccessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TmriJaxRpcOutNewAccessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TmriOutNewAccess
    private java.lang.String TmriOutNewAccess_address = "http://172.6.26.14:9080/pnweb/services/TmriOutNewAccess";

    public java.lang.String getTmriOutNewAccessAddress() {
        return TmriOutNewAccess_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TmriOutNewAccessWSDDServiceName = "TmriOutNewAccess";

    public java.lang.String getTmriOutNewAccessWSDDServiceName() {
        return TmriOutNewAccessWSDDServiceName;
    }

    public void setTmriOutNewAccessWSDDServiceName(java.lang.String name) {
        TmriOutNewAccessWSDDServiceName = name;
    }

    public TmriJaxRpcOutNewAccess getTmriOutNewAccess() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TmriOutNewAccess_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTmriOutNewAccess(endpoint);
    }

    public TmriJaxRpcOutNewAccess getTmriOutNewAccess(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TmriOutNewAccessSoapBindingStub _stub = new TmriOutNewAccessSoapBindingStub(portAddress, this);
            _stub.setPortName(getTmriOutNewAccessWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTmriOutNewAccessEndpointAddress(java.lang.String address) {
        TmriOutNewAccess_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (TmriJaxRpcOutNewAccess.class.isAssignableFrom(serviceEndpointInterface)) {
                TmriOutNewAccessSoapBindingStub _stub = new TmriOutNewAccessSoapBindingStub(new java.net.URL(TmriOutNewAccess_address), this);
                _stub.setPortName(getTmriOutNewAccessWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TmriOutNewAccess".equals(inputPortName)) {
            return getTmriOutNewAccess();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://172.6.26.14:9080/pnweb/services/TmriOutNewAccess", "TmriJaxRpcOutNewAccessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://172.6.26.14:9080/pnweb/services/TmriOutNewAccess", "TmriOutNewAccess"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TmriOutNewAccess".equals(portName)) {
            setTmriOutNewAccessEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
