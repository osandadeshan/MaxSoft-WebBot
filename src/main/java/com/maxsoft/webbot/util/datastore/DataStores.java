package com.maxsoft.webbot.util.datastore;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;

/**
 * Project Name : MaxSoft-WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/06/2019
 * Time         : 17:37
 * Description  :
 **/


public class DataStores {

    public static String getScenarioDataStoreValue(String variableNameOfValueStoredInDataStore, boolean isMessageVisible) {
        try {
            // Fetching Value from the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            String value = (String) scenarioStore.get(variableNameOfValueStoredInDataStore);
            if (isMessageVisible) {
                System.out.println("Text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
                Gauge.writeMessage("Text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            }
            return value;
        } catch (Exception ex) {
            if (isMessageVisible) {
                System.out.println("Failed to read the text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
                Gauge.writeMessage("Failed to read the text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            }
            return "";
        }
    }

    public static String getSpecificationDataStoreValue(String variableNameOfValueStoredInDataStore, boolean isMessageVisible) {
        try {
            // Fetching Value from the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            String value = (String) specDataStore.get(variableNameOfValueStoredInDataStore);
            if (isMessageVisible) {
                System.out.println("Text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
                Gauge.writeMessage("Text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            }
            return value;
        } catch (Exception ex) {
            if (isMessageVisible) {
                System.out.println("Failed to read the text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
                Gauge.writeMessage("Failed to read the text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            }
            return "";
        }
    }

    public static String getSuiteDataStoreValue(String variableNameOfValueStoredInDataStore, boolean isMessageVisible) {
        try {
            // Fetching Value from the Data Store
            DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
            String value = (String) suiteStore.get(variableNameOfValueStoredInDataStore);
            if (isMessageVisible) {
                System.out.println("Text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
                Gauge.writeMessage("Text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            }
            return value;
        } catch (Exception ex) {
            if (isMessageVisible) {
                System.out.println("Failed to read the text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
                Gauge.writeMessage("Failed to read the text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            }
            return "";
        }
    }

    public static void saveToScenarioDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore, boolean isMessageVisible) {
        try {
            // Adding value to the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            scenarioStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            if (isMessageVisible) {
                System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
                Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            }
        } catch (Exception ex) {
            if (isMessageVisible) {
                System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
                Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            }
        }
    }

    public static void saveToSpecificationDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore, boolean isMessageVisible) {
        try {
            // Adding value to the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            specDataStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            if (isMessageVisible) {
                System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
                Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            }
        } catch (Exception ex) {
            if (isMessageVisible) {
                System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
                Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            }
        }
    }

    public static void saveToSuiteDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore, boolean isMessageVisible) {
        try {
            // Adding value to the Data Store
            DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
            suiteStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            if (isMessageVisible) {
                System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
                Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            }
        } catch (Exception ex) {
            if (isMessageVisible) {
                System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
                Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            }
        }
    }

    public static void saveToDataStore(String dataStoreType, String variableName, String valueToBeStored, boolean isMessageVisible){
        switch (dataStoreType.toLowerCase()){
            case "spec":
                saveToSpecificationDataStore(variableName, valueToBeStored, isMessageVisible);
                break;
            case "specification":
                saveToSpecificationDataStore(variableName, valueToBeStored, isMessageVisible);
                break;
            case "scenario":
                saveToScenarioDataStore(variableName, valueToBeStored, isMessageVisible);
                break;
            case "suite":
                saveToSuiteDataStore(variableName, valueToBeStored, isMessageVisible);
                break;
            default:
                Assert.fail("Please provide a valid data store type");
        }
    }

    public static String readFromDataStore(String dataStoreType, String variableName, boolean isMessageVisible){
        String value = "";
        switch (dataStoreType.toLowerCase()){
            case "spec":
                value = getSpecificationDataStoreValue(variableName, isMessageVisible);
                break;
            case "specification":
                value = getSpecificationDataStoreValue(variableName, isMessageVisible);
                break;
            case "scenario":
                value = getScenarioDataStoreValue(variableName, isMessageVisible);
                break;
            case "suite":
                value = getSuiteDataStoreValue(variableName, isMessageVisible);
                break;
            default:
                Assert.fail("Please provide a valid data store type");
        }
        return value;
    }


}