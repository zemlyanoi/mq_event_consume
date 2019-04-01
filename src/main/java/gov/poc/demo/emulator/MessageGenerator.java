package gov.poc.demo.emulator;
import com.poc.demo.pojo.ColSchemaType;
import com.poc.demo.pojo.LoadPhaseEnumType;
import com.poc.demo.pojo.DbServerTypeEnumType;
import com.poc.demo.pojo.UpdateRowType;
import com.poc.demo.pojo.SingleValRowType;
import java.math.BigInteger;
import com.poc.demo.pojo.SubDeactivatedType;
import com.poc.demo.pojo.HeartbeatType;
import com.poc.demo.pojo.AddColumnType;
import com.poc.demo.pojo.TransType;
import com.poc.demo.pojo.SubSchemaType;
import com.poc.demo.pojo.RowOpType;
import com.poc.demo.pojo.LobType;
import com.poc.demo.pojo.ErrorRptType;
import com.poc.demo.pojo.LoadDoneRcvdType;

import com.poc.demo.pojo.MsgType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MessageGenerator {

  public MsgType generateMessageType(Boolean isLast, String cmitLSN) {
    MsgType msgType = new MsgType();

    TransType transType = new TransType();
    if (isLast == null) {
      transType.setIsLast(false);
    } else {
      transType.setIsLast(isLast);
    }
    transType.setIsLast(isLast);
    transType.setSegmentNum(BigInteger.ONE);
    transType.setCmitLSN("test");
    transType.setCmitTime(null);
    transType.setAuthID("test");
    transType.setCorrelationID("");
    transType.setPlanName("test");

    msgType.setTrans(transType);

    RowOpType rowOpType = new RowOpType();
    rowOpType.setInsertRow(new SingleValRowType());
    rowOpType.setDeleteRow(new SingleValRowType());
    rowOpType.setUpdateRow(new UpdateRowType());

    if (isLast == null) {
      rowOpType.setIsLast(false);
    } else {
      rowOpType.setIsLast(isLast);
    }
    rowOpType.setCmitLSN(cmitLSN);
    rowOpType.setCmitTime(null);
    rowOpType.setAuthID("test");
    rowOpType.setCorrelationID("test");
    rowOpType.setPlanName("test");

    msgType.setRowOp(rowOpType);

    SubDeactivatedType subDeactivatedType = new SubDeactivatedType();
    subDeactivatedType.setStateInfo("test");
    subDeactivatedType.setSubName("test");
    subDeactivatedType.setSrcOwner("test");
    subDeactivatedType.setSrcName("test");
    subDeactivatedType.setIntentSEQ("test");

    msgType.setSubDeactivated(subDeactivatedType);

    LoadDoneRcvdType loadDoneRcvdType = new LoadDoneRcvdType();
    loadDoneRcvdType.setStateInfo("test");
    loadDoneRcvdType.setSubName("test");
    loadDoneRcvdType.setSrcOwner("test");
    loadDoneRcvdType.setSrcName("test");
    loadDoneRcvdType.setIntentSEQ("test");

    msgType.setLoadDoneRcvd(loadDoneRcvdType);

    HeartbeatType heartbeatType = new HeartbeatType();
    heartbeatType.setSendQName("test");
    heartbeatType.setLastCmitTime(null);

    msgType.setHeartbeat(heartbeatType);

    ErrorRptType errorRptType = new ErrorRptType();
    errorRptType.setErrorMsg("test");
    errorRptType.setSubName("test");
    errorRptType.setSrcOwner("test");
    errorRptType.setSrcName("test");
    errorRptType.setIntentSEQ("test");

    msgType.setErrorRpt(errorRptType);

    SubSchemaType subSchemaType = new SubSchemaType();
    subSchemaType.setSendQName("test");
    subSchemaType.setAllChangedRows(false);
    subSchemaType.setBeforeValues(false);
    subSchemaType.setChangedColsOnly(false);
    subSchemaType.setHasLoadPhase(LoadPhaseEnumType.EXTERNAL);
    subSchemaType.setDbServerType(DbServerTypeEnumType.QDB_2);
    subSchemaType.setDbRelease("test");
    subSchemaType.setDbInstance("test");
    subSchemaType.setCapRelease("test");
    subSchemaType.setTimestamp("test");
    subSchemaType.setSubName("test");
    subSchemaType.setSrcOwner("test");
    subSchemaType.setSrcName("test");
    subSchemaType.setIntentSEQ("test");

    msgType.setSubSchema(subSchemaType);

    LobType lobType = new LobType();
    msgType.setLob(lobType);

    AddColumnType addColumnType = new AddColumnType();
    addColumnType.setCol(new ColSchemaType());
    addColumnType.setSubName("test");
    addColumnType.setSrcOwner("test");
    addColumnType.setSrcName("test");
    addColumnType.setIntentSEQ("test");

    msgType.setAddColumn(addColumnType);
    msgType.setVersion("");
    msgType.setDbName("");

    return msgType;
  }

  public MsgType generateMessageType() {
    return generateMessageType(null, "");
  }
}
