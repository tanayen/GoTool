$(document)
    .ready(
        function () {

            //Date range picker

            $('#reservation').daterangepicker({
                autoUpdateInput: false,
                locale: {
                    cancelLabel: 'Clear'
                }
            });

            $('#reservation').on('apply.daterangepicker', function (ev, picker) {
                $(this).val(picker.startDate.format('YYYY-MM-DD') + ' - ' + picker.endDate.format('YYYY-MM-DD'));
                table.ajax.url("ajax/tbStatPayment?rangeDate=" + $("#reservation").val()).load();

            });

            $('#reservation').on('cancel.daterangepicker', function (ev, picker) {
                $(this).val('');
                table.ajax.url("ajax/tbStatPayment?rangeDate=" + $("#reservation").val()).load();
            });

            var table = $('#example1').DataTable({
                "processing": true,
                "serverSide": true,
                "ajax": {
                    "url": "ajax/tbStatPayment?rangeDate=" + $("#reservation").val(),
                    "type": "POST",
                    "dataType": "json",
                    "data": {
                        "_csrf": $("#_csrf").val()
                    }
                }
            });



        }
    )