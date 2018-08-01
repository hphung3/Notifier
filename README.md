# Notifier
Notifies users using Twilio SMS

## Insert Twilio Credentials in src/main/resources/application.yml for sending SMS to users
```
twilio:
  account:
    sid: {{sid}}
    auth_token: {{token}}
    from_number: {{twilio_number}}
```
