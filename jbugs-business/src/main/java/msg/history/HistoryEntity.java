package msg.history;

import edu.msg.ro.persistence.entity.BaseEntity;

import java.util.Date;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class HistoryEntity extends BaseEntity<Long> {
    private Date modifiedDate;
    private String afterDate;

}
