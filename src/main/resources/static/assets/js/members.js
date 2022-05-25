$('document').ready(function() {
    $('table #editButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function(member, status) {
            $('#libraryIdEdit').val(member.libraryId);
            $('#firstNameEdit').val(member.firstName);
            $('#lastNameEdit').val(member.lastName);
            $('#emailAddressEdit').val(member.emailAddress);
            $('#phoneNumberEdit').val(member.phoneNumber);
            $('#addressEdit').val(member.address);
        });
        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal('show');
    });
});