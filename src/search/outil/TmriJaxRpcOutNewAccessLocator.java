/**
 * TmriJaxRpcOutNewAccessLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package search.outil;

public class TmriJaxRpcOutNewAccessLocator extends org.apache.axis.client.Service implements TmriJaxRpcOutNewAccess {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TmriJaxRpcOutNewAccessLocator() {
    }


    public TmriJaxRpcOutNewAccessLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TmriJaxRpcOutNewAccessLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TmriJaxRpcOutNewAccessSoap
    private java.lang.String TmriJaxRpcOutNewAccessSoap_address = "http://172.6.46.2/jcxws/TmriOutNewAccess.asmx";

    public java.lang.String getTmriJaxRpcOutNewAccessSoapAddress() {
        return TmriJaxRpcOutNewAccessSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TmriJaxRpcOutNewAccessSoapWSDDServiceName = "TmriJaxRpcOutNewAccessSoap";

    public java.lang.String getTmriJaxRpcOutNewAccessSoapWSDDServiceName() {
        return TmriJaxRpcOutNewAccessSoapWSDDServiceName;
    }

    public void setTmriJaxRpcOutNewAccessSoapWSDDServiceName(java.lang.String name) {
        TmriJaxRpcOutNewAccessSoapWSDDServiceName = name;
    }

    public TmriJaxRpcOutNewAccessSoap getTmriJaxRpcOutNewAccessSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TmriJaxRpcOutNewAccessSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTmriJaxRpcOutNewAccessSoap(endpoint);
    }

    public TmriJaxRpcOutNewAccessSoap getTmriJaxRpcOutNewAccessSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TmriJaxRpcOutNewAccessSoapStub _stub = new TmriJaxRpcOutNewAccessSoapStub(portAddress, this);
            _stub.setPortName(getTmriJaxRpcOutNewAccessSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTmriJaxRpcOutNewAccessSoapEndpointAddress(java.lang.String address) {
        TmriJaxRpcOutNewAccessSoap_address = address;
    }


    // Use to get a proxy class for TmriJaxRpcOutNewAccessSoap12
    private java.lang.String TmriJaxRpcOutNewAccessSoap12_address = "http://172.6.46.2/jcxws/TmriOutNewAccess.asmx";

    public java.lang.String getTmriJaxRpcOutNewAccessSoap12Address() {
        return TmriJaxRpcOutNewAccessSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TmriJaxRpcOutNewAccessSoap12WSDDServiceName = "TmriJaxRpcOutNewAccessSoap12";

    public java.lang.String getTmriJaxRpcOutNewAccessSoap12WSDDServiceName() {
        return TmriJaxRpcOutNewAccessSoap12WSDDServiceName;
    }

    public void setTmriJaxRpcOutNewAccessSoap12WSDDServiceName(java.lang.String name) {
        TmriJaxRpcOutNewAccessSoap12WSDDServiceName = name;
    }

    public TmriJaxRpcOutNewAccessSoap getTmriJaxRpcOutNewAccessSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TmriJaxRpcOutNewAccessSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTmriJaxRpcOutNewAccessSoap12(endpoint);
    }

    public TmriJaxRpcOutNewAccessSoap getTmriJaxRpcOutNewAccessSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TmriJaxRpcOutNewAccessSoap12Stub _stub = new TmriJaxRpcOutNewAccessSoap12Stub(portAddress, this);
            _stub.setPortName(getTmriJaxRpcOutNewAccessSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTmriJaxRpcOutNewAccessSoap12EndpointAddress(java.lang.String address) {
        TmriJaxRpcOutNewAccessSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (TmriJaxRpcOutNewAccessSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                TmriJaxRpcOutNewAccessSoapStub _stub = new TmriJaxRpcOutNewAccessSoapStub(new java.net.URL(TmriJaxRpcOutNewAccessSoap_address), this);
                _stub.setPortName(getTmriJaxRpcOutNewAccessSoapWSDDServiceName());
                return _stub;
            }
            if (TmriJaxRpcOutNewAccessSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                TmriJaxRpcOutNewAccessSoap12Stub _stub = new TmriJaxRpcOutNewAccessSoap12Stub(new java.net.URL(TmriJaxRpcOutNewAccessSoap12_address), this);
                _stub.setPortName(getTmriJaxRpcOutNewAccessSoap12WSDDServiceName());
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
        if ("TmriJaxRpcOutNewAccessSoap".equals(inputPortName)) {
            return getTmriJaxRpcOutNewAccessSoap();
        }
        else if ("TmriJaxRpcOutNewAccessSoap12".equals(inputPortName)) {
            return getTmriJaxRpcOutNewAccessSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "TmriJaxRpcOutNewAccess");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "TmriJaxRpcOutNewAccessSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "TmriJaxRpcOutNewAccessSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TmriJaxRpcOutNewAccessSoap".equals(portName)) {
            setTmriJaxRpcOutNewAccessSoapEndpointAddress(address);
        }
        else 
if ("TmriJaxRpcOutNewAccessSoap12".equals(portName)) {
            setTmriJaxRpcOutNewAccessSoap12EndpointAddress(address);
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
