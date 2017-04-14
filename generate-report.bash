#!/bin/bash

CURL="curl -s -f"
CONFIG_FILE=$1

source $CONFIG_FILE

NEW_LINE='<br>'

TABLE_BEGIN='<table class="table table-striped">'
    TABLE_HEAD_BEGIN='<thead class="thead-inverse">'
        TABLE_ROW_BEGIN='<tr>'
            TABLE_HEAD_LABEL_BEGIN='<th>'
            TABLE_HEAD_LABEL_END='</th>'
            # ...
        TABLE_ROW_END='</tr>'
    TABLE_HEAD_END='</thead>'
    TABLE_BODY_BEGIN='<tbody>'
        #TABLE_ROW_BEGIN
            TABLE_BODY_VALUE_BEGIN='<td>'
            TABLE_BODY_VALUE_END='</td>'
            # ...
        #TABLE_ROW_END
    TABLE_BODY_END='</tbody>'
TABLE_END='</table>'

function load-table() {

  OUT_HTML=$OUT_DIR/JOB_ID.html

  rm -fr $LOG_DIR
  mkdir -p $LOG_DIR
  mkdir -p $OUT_DIR

  export TITLE=TITLE

  cat html/header.html | envsubst > $OUT_HTML

  echo "$TABLE_BEGIN" >> $OUT_HTML
  echo "$TABLE_HEAD_BEGIN" >> $OUT_HTML
  echo "$TABLE_ROW_BEGIN" >> $OUT_HTML

    echo "$TABLE_HEAD_LABEL_BEGIN" >> $OUT_HTML
    echo "DATE" >> $OUT_HTML
    echo "$TABLE_HEAD_LABEL_END" >> $OUT_HTML

    echo "$TABLE_HEAD_LABEL_BEGIN" >> $OUT_HTML
    echo "LINKS" >> $OUT_HTML
    echo "$TABLE_HEAD_LABEL_END" >> $OUT_HTML

  echo "$TABLE_ROW_END" >> $OUT_HTML
  echo "$TABLE_HEAD_END" >> $OUT_HTML

  echo "$TABLE_BODY_BEGIN" >> $OUT_HTML
  export CHART_VCORES=""
  export CHART_MB=""
  for i in `seq $TO_JOB -1 $FROM_JOB`;
  do
      echo "$TABLE_ROW_BEGIN" >> $OUT_HTML

      echo "$TABLE_BODY_VALUE_BEGIN" >> $OUT_HTML # DATE
      cat $LOG_DIR/$i.jenkins.log | grep "UTC 20" >> $OUT_HTML
      echo "$TABLE_BODY_VALUE_END" >> $OUT_HTML

      echo "$TABLE_BODY_VALUE_BEGIN" >> $OUT_HTML # LINKS
      echo "<a href=\"$JENKINS_JOB_URL\">Jenkins</a>" >> $OUT_HTML
      echo "$NEW_LINE" >> $OUT_HTML
      echo "<a href=\"$TRACKING_URL\">Yarn</a>" >> $OUT_HTML
      echo "$TABLE_BODY_VALUE_END" >> $OUT_HTML

      if [ "$MB_SECONDS" != "" ]
      then
          export CHART_MB="[$i, $MB_SECONDS], $CHART_MB"
      fi

      if [ "$VCORE_SECONDS" != "" ]
      then
          export CHART_VCORES="[$i, $VCORE_SECONDS], $CHART_VCORES"
      fi

      echo "$TABLE_ROW_END" >> $OUT_HTML

  done

  echo "$TABLE_BODY_END" >> $OUT_HTML
  echo "$TABLE_END" >> $OUT_HTML

  cat html/tail.html | envsubst  >> $OUT_HTML

}

load-table $TABLE_PATH

