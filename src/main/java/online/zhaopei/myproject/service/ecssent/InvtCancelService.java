package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.InvtCancel;

public interface InvtCancelService extends Serializable {

	List<InvtCancel> getInvtCancelList(InvtCancel invtCancel);
}
