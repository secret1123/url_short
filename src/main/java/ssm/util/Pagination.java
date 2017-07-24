package ssm.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/23 21:57.
 * ssm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<T> implements Serializable {
    private List<T> list;
    private String statement;
    private int pageSize;
    private int totalRows;
    private int totalPages;
    private int currentPage;
}
