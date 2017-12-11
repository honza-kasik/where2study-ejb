package cz.honzakasik.upol.where2study.datamanage;

import javax.ejb.Local;

/**
 * Interface for introducing methods managing removal of all persisted data
 */
@Local
public interface DataPurge {

	/**
	 * Removes everything stored in database except users
	 */
	void purgeAllPersistedData();

}
