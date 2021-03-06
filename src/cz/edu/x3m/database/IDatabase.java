package cz.edu.x3m.database;

import cz.edu.x3m.database.structure.PlagItem;
import cz.edu.x3m.database.structure.QueueItem;
import cz.edu.x3m.database.structure.AttemptItem;
import cz.edu.x3m.database.data.GradeMethod;
import cz.edu.x3m.database.structure.TaskItem;
import cz.edu.x3m.database.data.types.AttemptStateType;
import cz.edu.x3m.database.exception.DatabaseException;
import cz.edu.x3m.database.structure.AttemptItem;
import cz.edu.x3m.database.structure.UserItem;
import cz.edu.x3m.grading.ISolutionGradingResult;
import cz.edu.x3m.plagiarism.IPlagResult;
import cz.edu.x3m.processing.IRunEvaluation;
import cz.edu.x3m.processing.execution.IExecutionResult;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jan Hybs
 */
public interface IDatabase {

    /**
     * Connects to Database
     *
     * @return true if connection was established or false if database is already connected
     * @throws DatabaseException on connect error
     */
    boolean connect () throws DatabaseException;



    /**
     * Closes Database connection
     *
     * @return true if connection was closed or false if database is already closed
     * @throws DatabaseException on close error
     */
    boolean close () throws DatabaseException;



    /**
     * Loads all queue items Every item is join to particullar task instance
     *
     * @return list of all items
     * @throws DatabaseException on load error
     */
    List<QueueItem> getQueueItems () throws DatabaseException;



    /**
     * Method deletes item from Database
     *
     * @param item to be deleted
     * @return true if deletion was successful otherwise false
     * @throws DatabaseException on error
     */
    boolean deleteQueueItem (QueueItem item) throws DatabaseException;



    /**
     * Gets solution check detail for the given task id and related (student/teacher) id
     *
     * @param taskID codiana id
     * @param userID student/teacher id
     * @return detailed object
     * @throws DatabaseException on error
     */
    AttemptItem getAttemptItem (int taskID, int userID) throws DatabaseException;



    /**
     * Gets plagiarism check detail for the given task id and related (student/teacher) id
     *
     * @param taskID codiana id
     * @param relatedID student/teacher id
     * @return detailed object
     * @throws DatabaseException on error
     */
    PlagItem getPlagItem (int taskID, int relatedID, GradeMethod gradeMethod) throws DatabaseException;



    /**
     * Saves grading result to DB from given solution grading result (from monitors results)
     *
     * @param item to be updated
     * @param result grading result
     * @param attemptStateType final attempt state
     * @return true on success false on update
     * @throws DatabaseException on error
     */
    boolean saveGradingResult (QueueItem item, ISolutionGradingResult result, AttemptStateType attemptStateType) throws DatabaseException;



    /**
     * Saves grading result to DB from given execution result (from monitors results)
     *
     * @param item to be updated
     * @param result execution result
     * @return true on success false on update
     * @throws DatabaseException on error
     */
    boolean saveGradingResult (AttemptItem item, IRunEvaluation result) throws DatabaseException;



    /**
     * Saves plagiarism result to DB
     *
     * @param item to be updated
     * @param result plagiarism result
     * @return true on success false on update
     * @throws DatabaseException on error
     */
    boolean savePlagCheckResult (QueueItem item, IPlagResult result) throws DatabaseException;



    /**
     * Method save reasult from measurement check Results are detected from execution
     *
     * @param item task item
     * @param result execution result
     * @return true on success false on no update
     * @throws DatabaseException when sql error occurs
     */
    boolean saveMeasurementResult (TaskItem item, IRunEvaluation result) throws DatabaseException;



    /**
     * Sets Database setting such as username, password, etc.
     *
     * @param settings object containing all settings
     * @throws DatabaseException on empty settings
     */
    void setSettings (DatabaseSetting settings) throws DatabaseException;



    /**
     * Method sets given state to given queue item, along with optional string note
     *
     * @param queueItem queue item object
     * @param state new state which will be set
     * @param details null or string value, serves as note
     * @return true on success false otherwise
     * @throws DatabaseException when sql error occurs
     */
    boolean saveGradingResult (QueueItem queueItem, AttemptStateType state, String details) throws DatabaseException;



    public UserItem getUserItem (int id) throws DatabaseException;



    public TaskItem getTaskItem (int id) throws DatabaseException;



    public AttemptItem getAttemptItem (int id) throws DatabaseException;



    public Map<String, String> loadPluginConfig () throws DatabaseException;
}
